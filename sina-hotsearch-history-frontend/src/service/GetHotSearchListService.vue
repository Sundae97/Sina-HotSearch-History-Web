<script>
    import axios from 'axios'
    import config_data from "../../public/config/config"

    const base_url = config_data.GET_SINA_HOTSEARCH_BASE_URL;

    export default {
        methods: {
            getHotSearchListByTime(time) {
                return new Promise((resolve, reject) => {
                    axios({
                        method: 'GET',
                        url: base_url + '/sina/get_hotsearch_detail_list?time=' + time,
                    }).then((response) => {
                        resolve(response.data);
                    }).catch((error) => {
                        reject(error);
                    })
                });
            }
        }
    }
</script>
