<template>
  <v-container style="padding: 0px;">
    <v-row align="start" justify="center" no-gutters>
      <v-col style="margin-right: 8px;margin-bottom: 100px;">
        <v-timeline style="left: -8px;" align-top dense>
          <v-timeline-item
                  v-for="(item, i) in items"
                  :key="i+1"
                  :color="time_line_num_color"
                  :icon="(i+1)+''"
                  fill-dot
                  left
                  class="wow flipInX"
                  style="padding-bottom: 18px;"
          >
              <v-card
                      class="mx-auto"
                      :color="item.color"
              >
                <v-card-title style="font-size: 1.1em;padding: 8px;" v-on:click="item.show = !item.show" v-ripple>
                  {{item.title}}
                  <v-spacer></v-spacer>

                  <v-btn
                          icon
                  >
                    <v-icon>{{ item.show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                  </v-btn>
                </v-card-title>


                <v-expand-transition>
                  <div v-show="item.show">
                    <v-divider></v-divider>
                    <v-row style="padding: 5px;">
                      <v-col class="blog-card" v-for="(blogItem, blogDetailIndex) in item.blogDetails" :key="blogDetailIndex">
                        <BlogCard v-bind:blogContent="blogItem"/>
                      </v-col>
                    </v-row>
                  </div>
                </v-expand-transition>
              </v-card>
          </v-timeline-item>
        </v-timeline>
      </v-col>
    </v-row>
<!--      <v-progress-circular-->
<!--              :size="70"-->
<!--              :width="7"-->
<!--              color="purple"-->
<!--              indeterminate-->
<!--      ></v-progress-circular>-->

  </v-container>
</template>

<style scoped>
  .v-progress-circular {
    margin: 1rem;
  }

</style>

<script>
  import GetHotSearchListService from "@/service/GetHotSearchListService";
  import {WOW} from 'wowjs'
  import BlogCard from "@/components/BlogCard";

  export default {
    name: 'MainContent',
    components: {BlogCard},
    data: () => ({
      _this: this,
      time_line_num_color: "#edaa29",
      items: [],
    }),
    mounted(){
      this.initList();
      this.initWOW();
    },
    methods: {
      initWOW() {
        const wow = new WOW({
          boxClass: 'wow',
          animateClass: 'animated',
          offset: 0,
          mobile: true,
          live: true
        });
        wow.init()
      },
      initList(){
        for (let i = 0; i < 50; i++) {
          this.items.push({color: '#ebebeb', show:false, title: ""});
        }
      },
      async updateHotSearchList(time) {
        let response = await GetHotSearchListService.methods.getHotSearchListByTime(time);
        console.log(response);
        if(!response.success){
          alert("出现错误");
          return;
        }
        if(response.code == 1){
          this.renderHotSearchList(response.data);
        }
      },
      renderHotSearchList(data) {
        this.items.splice(0);
        for(const rank in data){
          const item = data[""+rank];
          this.addDataToList(item);
        }
      },
      addDataToList(item){
        this.items.push({color: '#ebebeb', show:false, title: item["desc"], blogDetails: item["blogDetails"]})
      }
    }
  }
</script>
