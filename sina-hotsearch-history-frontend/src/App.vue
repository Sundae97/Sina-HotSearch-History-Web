<template>
    <v-app id="main">
        <v-app-bar
                :height="58"
                color="amber darken-2"
                app
                dense
                dark
                hide-on-scroll
        >
            <v-app-bar-nav-icon @click.stop="drawer = !drawer"/>
            <v-toolbar-title
                    style="width: 300px"
                    class="ml-0 pl-4"
            >
                <span class="">微博热搜</span>
            </v-toolbar-title>
            <v-text-field
                    flat
                    solo-inverted
                    hide-details
                    prepend-inner-icon="mdi-magnify"
                    label="Search"
                    class=""
            />
            <v-spacer/>
        </v-app-bar>

        <v-navigation-drawer
                v-model="drawer"
                :width="320"
                app
        >
            <MainDrawerContent @closeDrawer="closeDrawer"/>
        </v-navigation-drawer>

        <v-content>
            <MainContent id="scroll-target"/>
            <v-btn
                    bottom
                    color="blue"
                    @click="$vuetify.goTo('#scroll-target', {offset:0,duration:600,easing:'easeInOutCubic'})"
                    dark
                    fab
                    fixed
                    right
            >
                <v-icon>mdi-chevron-up</v-icon>
            </v-btn>
        </v-content>

    </v-app>
</template>

<script>
    import MainDrawerContent from "@/components/MainDrawerContent";
    import MainContent from "@/components/MainContent";

    export default {
        name: 'App',

        components: {
            MainDrawerContent,
            MainContent,
        },
        data: () => ({
            drawer: null,
        }),
        methods:{
            closeDrawer() {
                this.drawer = false;
            }
        }
    };
</script>
