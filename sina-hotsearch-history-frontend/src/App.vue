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
          <el-backtop></el-backtop>
        </v-content>

    </v-app>
</template>

<script>
    import MainDrawerContent from "@/components/MainDrawerContent";
    import MainContent_PC from "@/components/MainContent/MainContent_PC";
    import MainContent_Mobile from "@/components/MainContent/MainContent_Mobile";

    let MainContent;

    function _isMobile(){
        // let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
        // return flag;
        return document.documentElement.clientWidth < 650;
    }

    if (_isMobile()) {
        MainContent = MainContent_Mobile;
    } else {
        MainContent = MainContent_PC;
    }
    export default {
        name: 'App',

        components: {
            MainDrawerContent,
            MainContent,
        },
        data: () => ({
            drawer: null,
        }),
        methods: {
            closeDrawer() {
                this.drawer = false;
            },
        },
    };
</script>
