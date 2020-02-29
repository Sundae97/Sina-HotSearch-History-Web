<template>
    <div>
        <v-row justify="center">
            <v-date-picker style="margin: 10px 18px;" v-model="date_picker" locale="zh-cn"  color="amber darken-1"/>
        </v-row>
        <v-row justify="center">
            <v-time-picker v-model="time_picker" format="24hr" :ampm-in-title="true" locale="zh-cn" color="amber darken-1"></v-time-picker>
        </v-row>
        <v-row justify="center" style="margin-top: 30px;margin-bottom: 18px;">
            <div class="text-center" style="margin-right: 24px;">
                <v-btn v-on:click="queryBtnClick" rounded color="warning" dark> 查 询 </v-btn>
            </div>
            <div class="text-center">
                <v-btn v-on:click="realTimeBtnClick" rounded color="success" dark> 实 时 </v-btn>
            </div>
        </v-row>
    </div>
</template>

<script>
    import axios from 'axios'
    import config_data from "../../public/config/config"

    const base_url = config_data.GET_SINA_HOTSEARCH_BASE_URL;
    export default {
        name: 'MainDrawerList',
        props: {

        },
        data: () => ({
            date_picker: null,
            time_picker: null ,
        }),
        created () {
            this.date_picker = this.getTodayStr();
            this.time_picker = this.getNowTimeStr();
            axios({
                method: 'GET',
                url: base_url + '/sina/get_hotsearch_detail_list?time=1582362420000',
            }).then((response) => {
                console.log(response)
            }).catch((error) => {
                console.log(error)
            })
        },
        methods: {
            queryBtnClick:function () {
                let date = this.$data.date_picker;
                let time = this.$data.time_picker;
                let str = date + " " + time;
                console.log("realTimeBtnClick ---> " + new Date(str).getTime());
                this.$emit("closeDrawer");
            },
            realTimeBtnClick: function () {
                console.log("realTimeBtnClick ---> " + new Date().getTime());
                this.$emit("closeDrawer");
            },
            getTodayStr: function () {
                let date = new Date();
                return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
            },
            getNowTimeStr: function () {
                let date = new Date();
                return date.getHours() + ":" + date.getMinutes();
            }
        }
    }
</script>