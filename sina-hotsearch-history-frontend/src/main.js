import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import 'animate.css'
import '@mdi/font/css/materialdesignicons.css'
import './plugins/element.js'

Vue.config.productionTip = false;

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app');
