<template>
  <v-container style="padding: 0px;">
    <v-row align="start" justify="center" no-gutters>
      <v-col style="margin-right: 8px;margin-bottom: 100px;">
        <v-timeline style="left: -8px;" align-top dense>
          <v-timeline-item
                  v-for="(item, i) in items"
                  :key="i+1"
                  :color="item.color"
                  :icon="(i+1)+''"
                  fill-dot
                  left
                  class="wow flipInX"
                  style="padding-bottom: 18px;"
          >
              <v-card
                      class="mx-auto"
                      :color="item.color"
                      dark
              >
                <v-card-title style="font-size: 1.1em;padding: 8px;" v-on:click="item.show = !item.show" v-ripple>
                  Top western road trips
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
                            <v-col class="blog-card"><BlogCard></BlogCard></v-col>
                            <v-col class="blog-card"><BlogCard></BlogCard></v-col>
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
  import {WOW} from 'wowjs'
  import BlogCard from "@/components/BlogCard";

  export default {
    name: 'MainContent',
    components: {BlogCard},
    data: () => ({
      items: [
        {
          show: false,
          color: 'orange darken-1',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'orange darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
        {
          show: false,
          color: 'red lighten-2',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'purple darken-1',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'green lighten-1',
          icon: 'mdi-airballoon',
        },
        {
          show: false,
          color: 'indigo',
          icon: 'mdi-buffer',
        },
      ],
    }),
    mounted(){
      const wow = new WOW({
        boxClass: 'wow',
        animateClass: 'animated',
        offset: 0,
        mobile: true,
        live: false
      })
      wow.init()
    },

  }
</script>
