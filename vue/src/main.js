import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuex from 'vuex'
import es6promise from 'es6-promise/auto'
import vueElementLoading from 'vue-element-loading'
import {store} from './store'

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
  router,
  axios,
  vuex,
  es6promise,
  vueElementLoading,
  store
}).$mount('#app')