<template>
    <div>
        <v-row justify="center">
            <v-date-picker ref="DatePicker" style="margin: 10px 18px;" v-model="date_picker" locale="zh-cn"  color="amber darken-1" :min="minDate" :max="maxDate"/>
        </v-row>
        <v-row justify="center">
            <v-time-picker v-model="time_picker" format="24hr" :ampm-in-title="true" locale="zh-cn" color="amber darken-1"></v-time-picker>
        </v-row>
        <v-row justify="center" style="margin-top: 30px;margin-bottom: 18px;">
            <div class="text-center" style="margin-right: 24px;">
                <v-btn v-on:click="queryBtnClick" rounded color="warning" dark> 查 询 </v-btn>
            </div>
            <div class="text-center">
                <v-btn v-on:click="realTimeBtnClick" rounded color="success" dark> 最 新 </v-btn>
            </div>
        </v-row>
    </div>
</template>

<script>
    import ApiService from "@/service/ApiService";
    import dateFormat from 'dateformat'

    export default {
        name: 'MainDrawerList',
        props: {

        },
        data: () => ({
            minDate: "2020-01-01",
            maxDate: "",
            date_picker: null,
            time_picker: null,
        }),
        created () {
            this.date_picker = this.getTodayStr();
            this.time_picker = this.getNowTimeStr();
        },
        mounted() {
            this.maxDate = dateFormat(new Date(), "yyyy-mm-dd");
            ApiService.methods.getEarliestHotSearchTime(this.initMinDate);
        },
        methods: {
            initMinDate(data){
                let date = new Date(data.data);
                this.minDate = dateFormat(date, "yyyy-mm-dd");
            },
            queryBtnClick() {
                this.callParentCloseDrawer();
                this.$emit("updateMainContentHotSearchList", this.getComponentsDateTime());
            },
            realTimeBtnClick() {
                this.callParentCloseDrawer();
                this.$emit("initLatestMainContentHotSearchList");
            },
            callParentCloseDrawer(){
                this.$emit("closeDrawer");
            },
            getComponentsDateTime() {
                let date = this.$data.date_picker;
                let time = this.$data.time_picker;
                let dateTimeStr = date + " " + time;
                return new Date(dateTimeStr).getTime();
            },
            getTodayStr () {
                let date = new Date();
                return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
            },
            getNowTimeStr () {
                let date = new Date();
                return date.getHours() + ":" + date.getMinutes();
            }
        }
    }
</script>
