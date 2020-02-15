<template>
  <v-container style="padding: 0px;">
    <v-row align="start" justify="center" no-gutters>
      <v-col style="margin-right: 16px;">
        <v-timeline align-top dense>
          <v-timeline-item
                  v-for="(item, i) in items"
                  :key="i"
                  :color="item.color"
                  :icon="i+''"
                  fill-dot
                  left
          >
            <v-card
                    class="mx-auto"
                    :color="item.color"
                    dark
            >
              <v-card-title v-on:click="item.show = !item.show" v-ripple>
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

                  <v-card-text class="white text--primary">
                    <v-card-text>
                      I'm a thing. But, like most politicians, he promised more than he could deliver. You won't have time for sleeping, soldier, not with all the bed making you'll be doing. Then we'll go with that data file! Hey, you add a one and two zeros to that or we walk! You're going to do his laundry? I've got to find a way to escape.
                    </v-card-text>
                    <v-card-text>
                      <v-btn
                              :color="item.color"
                              class="mx-0"
                              outlined
                      >
                        Button
                      </v-btn>
                    </v-card-text>
                  </v-card-text>

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
  export default {
    name: 'MainContent',

    data: () => ({
      items: [
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
  }
</script>
