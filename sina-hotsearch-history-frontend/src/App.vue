<template>
    <v-app id="app">
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
                style="z-index: 9999;"
                v-model="drawer"
                :width="320"
                app
        >
            <MainDrawerContent
                    @closeDrawer="closeDrawer"
                    @updateMainContentHotSearchList="updateMainContentHotSearchList"
                    @initLatestMainContentHotSearchList="initLatestMainContentHotSearchList"/>
        </v-navigation-drawer>

        <v-content>
            <MainContent ref="MainContent"></MainContent>
            <el-backtop/>
        </v-content>
    </v-app>
</template>

<style>
    html,body,#app{
        height: 100%;
    }
</style>

<script>
    import MainDrawerContent from "@/components/MainDrawerContent";
    import MainContent from "@/components/MainContent/MainContent_PC";

    export default {
        name: 'App',

        components: {
            MainDrawerContent,
            MainContent
        },
        data: () => ({
            drawer: null,
        }),
        methods: {
            closeDrawer() {
                this.drawer = false;
            },
            updateMainContentHotSearchList(time) {
                setTimeout(() => this.$refs.MainContent.updateHotSearchList(time), 300);
            },
            initLatestMainContentHotSearchList(){
                setTimeout(() => this.$refs.MainContent.initLatestHotSearchList(), 300);
            }
        },
        mounted() {
            this.$refs.MainContent.initLatestHotSearchList();
        },
    };
</script>
