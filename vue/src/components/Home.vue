<template>
	<div id="app">
	<layout>
		<template #header="header">
		<h2>{{header.title}}</h2>
		<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			<!-- <ul id="headstyle" class="menu">
				<button v-for="i of headers" :key= "i.menu">
					<router-link :to="i.link">{{i.menu}}</router-link>
				</button>
			</ul> -->
		</template>
		<template #sidebar="sidebar">  <!-- 사이더바에 메뉴 만들기 -->
			<ul class="menu">
				<li v-for="i of sidebars" :key= "i.menu">
					<router-link :to="i.link">{{i.menu}}</router-link>
				</li>
			</ul>
		</template>
		<template #content="content">
		</template>
		<template #footer="footer">
		<h1>{{footer.title}}</h1>
		</template>
	</layout>
	</div>
</template>
<script>
import Layout from '@/components/cmm/Layout.vue'
import PostAuth from '@/components/cmm/PostAuth.vue'
import PreAuth from '@/components/cmm/PreAuth.vue'
import { store } from "@/store"
export default {
	components: {Layout,PostAuth,PreAuth},
	data(){
		return { 
			sidebars: [
				{menu: "글쓰기", link: "/write"},
				{menu: "목록", link: "/list"},
				{menu: "글수정", link: "/update"},
				{menu: "글삭제", link: "/remove"},
				{menu: "검색", link: "/search"}

			]
		}
	},
	computed:{
		loginCheck: function(){
			return store.state.loginstate
		}
	}
}
</script>
<style scoped>
#headstyle{
	float: right;
}
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
</style>