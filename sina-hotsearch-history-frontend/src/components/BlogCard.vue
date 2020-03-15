<template>
    <v-card
            max-width="310px"
            min-width="200px"
            class="mx-auto"
            light
            elevation="12"
    >
        <v-list-item>
            <v-list-item-avatar color="grey"><v-img :src="blogContent.userHeadImgUrl == null ? '':blogContent.userHeadImgUrl"></v-img></v-list-item-avatar>
            <v-list-item-content>
                <v-list-item-title>{{blogContent.screenName}}</v-list-item-title>
            </v-list-item-content>
        </v-list-item>

        <v-img  height="200"
                :src="blogContent.picUrls[0] == null ? '' : blogContent.picUrls[0]"
        />

        <v-card-text>
            {{blogContent.text}}
        </v-card-text>

        <v-card-actions>
            <v-icon class="margin-n" size="18">mdi-share-circle</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">{{transformNum(blogContent.repostsCount)}}</span>
            <v-divider
                    class="mx-4"
                    inset
                    vertical
            ></v-divider>
            <v-icon class="margin-n" size="18">mdi-message</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">{{transformNum(blogContent.commentsCount)}}</span>
            <v-divider
                    class="mx-4"
                    inset
                    vertical
            ></v-divider>
            <v-icon class="margin-n" size="18">mdi-thumb-up</v-icon><span class="text-no-wrap caption" style="margin: 0px 4px;">{{transformNum(blogContent.attitudesCount)}}</span>
            <v-spacer></v-spacer>
            <v-btn icon :href="this.$data.baseMweiboUrl+blogContent.blogId" target="_blank">
                <v-icon>mdi-send</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        name: "BlogCard",
        props:{
            blogContent:{
                id:0,
                userId:0,
                screenName:"",
                userHeadImgUrl:"",
                blogId:"",
                text:"",
                picUrls:[],
                repostsCount:0,
                commentsCount:0,
                attitudesCount:0,
                time:0
            }
        },
        data:() => ({
            baseMweiboUrl:"https://m.weibo.cn/detail/"
        }),
        methods: {
            transformNum(num){
                return num < 1000 ? num : (num/1000).toFixed(1)+'k';
            }
        },
        mounted(){
        }
    }
</script>

<style scoped>
    .margin-n{
        margin: 10px 2px;
    }
</style>
