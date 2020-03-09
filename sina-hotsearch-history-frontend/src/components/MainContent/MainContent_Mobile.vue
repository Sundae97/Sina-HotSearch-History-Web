<template>
  <v-container style="padding: 0px;">
    <v-row align="start" justify="center" no-gutters>
      <v-col style="margin-right: 8px;margin-bottom: 100px;">

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
  // import BlogCard from "@/components/BlogCard";

  export default {
    name: 'MainContent',
    components: {
      // BlogCard
    },
    data: () => ({
      time_line_num_color: "white",
      items: [
        {
          show: false,
          color: 'white',
          icon: 'mdi-star',
        },
        {
          show: false,
          color: 'white',
          icon: 'mdi-book-variant',
        },
        {
          show: false,
          color: 'white',
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
      });
      wow.init()
    },

  }
</script>
