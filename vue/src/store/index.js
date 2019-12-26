import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'
Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
	loginedUid: '',
	loginedPw: '',
	id: '',
	name: '',
	birthday: '',
	gender: '',
	hak: '',
	ban: '',
	score: '',
	person: {},
	loginstate : false
  }
})