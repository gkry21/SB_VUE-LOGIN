import Vue from 'vue'
import Router from 'vue-router'
import Join from '@/components/member/Join.vue'
import Login from '@/components/member/Login.vue'
import Write from '@/components/board/Write.vue'
import Remove from '@/components/board/Remove.vue'
import List from '@/components/board/List.vue'
import Search from '@/components/board/Search.vue'
import Update from '@/components/board/Update.vue'
import Mypage from '@/components/member/Mypage.vue'

Vue.use(Router)

export default new Router({
	mode: 'history',
	routes: [
		{path: '/join' ,name: 'join',component: Join },
		{path: '/login' ,name: 'login',component: Login },
		{path: '/write' ,name: 'write',component: Write },
		{path: '/remove' ,name: 'remove',component: Remove },
		{path: '/list' ,name: 'list',component: List },
		{path: '/search' ,name: 'search',component: Search },
		{path: '/update' ,name: 'update',component: Update },
		{path: '/mypage' ,name: 'mypage',component: Mypage }
	]
	
})