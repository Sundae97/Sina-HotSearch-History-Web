<template>
  <v-container style="padding: 0px;">
    <v-row align="start" justify="center" no-gutters>
      <v-col style="margin-right: 8px;margin-bottom: 100px;">
        <v-timeline v-show="items != null && items.length > 0" align-top dense>
          <v-timeline-item
                  v-for="(item, i) in items"
                  :key="i+1"
                  :color="time_line_num_color"
                  :icon="(i+1)+''"
                  fill-dot
                  left
                  class="wow flipInY"
                  style="padding-bottom: 18px;"
          >
              <v-card
                      class="mx-auto mdi-format-wrap-inline"
                      :color="item.color"
              >
                <v-card-title style="font-size: 1.1em;padding: 8px;" v-on:click="item.show = !item.show" v-ripple>
                  <span style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;width: 86%;">{{item.title}}</span>
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
    <v-row style="margin-top: 180px;" v-if="items==null || items.length == 0"  justify="center">
      <h4>空空如也   ┭┮﹏┭┮</h4><br>
    </v-row>
  </v-container>
</template>

<style scoped>
  .v-timeline{
    left: -8px;
    -webkit-backface-visibility: hidden;
    -webkit-transform-style: preserve-3d;
  }
  h4{
    font-size: 1.3em;
    color: #7f7f7f;
    letter-spacing: 4px;
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
        let response;
        try{
          response = await GetHotSearchListService.methods.getHotSearchListByTime(time);
        }catch (e) {
          this.clearList();
          return;
        }
        if(response.code == 2){
          this.clearList();
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
        this.initWOW();
      },
      addDataToList(item){
        this.items.push({color: '#ebebeb', show:false, title: item["desc"], blogDetails: item["blogDetails"]})
      },
      clearList(){
        this.items.splice(0);
      }
    }
  }
</script>
