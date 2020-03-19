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
            getHotSearchListByTime(time) {
                return new Promise((resolve, reject) => {
                    this.openLoading();
                    axios({
                        method: 'GET',
                        url: base_url + '/sina/get_hotsearch_detail_list?time=' + time,
                    }).then((response) => {
                        if(response.data.code != 1)
                            this.showSuccessMessage("这里好像没有数据嗷~~ (●ˇ∀ˇ●)");
                        resolve(response.data);
                    }).catch((error) => {
                        this.showErrorMessage("网络好像出现错误了嗷~~ (　o=^•ェ•)o　┏━┓");
                        reject(error);
                    }).finally(() => {
                        this.closeLoading();
                    })
                });
            },
            openLoading(){
                this.loading = Loading.service({
                    lock: true,
                    fullscreen: false,
                    text: '正在加载中啦。。。 (づ￣ 3￣)づ',
                    spinner: 'el-icon-loading',
                    background: 'rgba(0, 0, 0, 0.7)'
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
