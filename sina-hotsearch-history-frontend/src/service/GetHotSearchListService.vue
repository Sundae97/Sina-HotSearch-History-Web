<script>
    import axios from 'axios'
    import config_data from "../../public/config/config"
    import { Loading, Message } from 'element-ui'

    const base_url = config_data.GET_SINA_HOTSEARCH_BASE_URL;

    export default {
        data: () => ({
            loading:null
        }),
        methods: {
            getLatestHotSearchTime(callback){
                this.openLoading();
                axios({
                    method: 'GET',
                    url: base_url + '/sina/get_latest_hotsearch_time',
                    timeout: 10000,
                }).then((response) => {
                    this.closeLoading();
                    if(response.data.code != 1)
                        this.showSuccessMessage("这里好像没有数据嗷~~ (●ˇ∀ˇ●)");
                    callback(response.data);
                }).catch(() => {
                    this.closeLoading();
                    this.showErrorMessage("网络好像出现错误了嗷~~ (　o=^•ェ•)o　┏━┓");
                })
            },
            getHotSearchListByTime(time, callback) {
                    this.openLoading();
                    axios({
                        method: 'GET',
                        url: base_url + '/sina/get_hotsearch_detail_list?time=' + time,
                        timeout: 10000,
                    }).then((response) => {
                        this.closeLoading();
                        if(response.data.code != 1)
                            this.showSuccessMessage("这里好像没有数据嗷~~ (●ˇ∀ˇ●)");
                        callback(response.data);
                    }).catch(() => {
                        this.closeLoading();
                        this.showErrorMessage("网络好像出现错误了嗷~~ (　o=^•ェ•)o　┏━┓");
                    })
            },
            openLoading(){
                this.loading = Loading.service({
                    lock: true,
                    target: '#main_content',
                    fullscreen: false,
                    text: '正在加载中啦。。。 (づ￣ 3￣)づ',
                    spinner: 'el-icon-loading',
                    background: 'rgba(0, 0, 0, 0.7)',

                });
            },
            closeLoading(){
                this.loading.close();
            },
            showSuccessMessage(message){
                Message.success({
                    showClose: true,
                    message: message,
                    offset: 80
                });
            },
            showErrorMessage(message){
                Message.error({
                    showClose: true,
                    message: message,
                    offset: 80
                });
            }
        }
    }
</script>
