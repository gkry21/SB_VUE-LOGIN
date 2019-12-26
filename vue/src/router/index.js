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
import Mypageupdate from '@/components/member/Mypageupdate.vue'
import Admin from '@/components/member/Admin.vue'
import Pagepick from '@/components/member/Pagepick.vue'


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
		{path: '/mypage' ,name: 'mypage',component: Mypage },
		{path: '/mypageupdate' ,name: 'mypageupdate',component: Mypageupdate },
		{path: '/admin' ,name: 'admin',component: Admin },
		{path: '/pagepick' ,name: 'pagepick',component: Pagepick }
	]
	
})