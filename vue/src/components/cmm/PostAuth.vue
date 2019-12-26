<template>
<div id="auth-box">
	<input type="button" value="로그아웃" @click.prevent="logout"/>
    <input type="button" value="회원탈퇴" @click.prevent="withdrawal"/>
</div>
</template>
<script>
import {store} from "../../store"
import axios from 'axios'
export default {
	data(){
		
		},
	methods: {
		logout(){
        store.state.loginUid = ''
        store.state.loginPw = ''
        store.state.name = ''
        store.state.id = ''
		store.state.birthday = ''
		store.state.gender = ''
		store.state.hak = ''
		store.state.ban = ''
		store.state.score = ''
		store.state.person = {}
		store.state.loginstate = false
        this.$router.push({path:'/home'})
		},
		withdrawal(){
      axios
      .delete(`${this.context}/withdrawal/${store.state.loginUid}`,
            {data(){
              store.state.loginUid = ''
              store.state.loginPw = ''
              store.state.name = ''
              store.state.id = ''
              store.state.birthday = ''
              store.state.person = {}
              store.state.loginstate = false
              this.$router.push({path:'/login'})}} 
     )}
	}
}
</script>
<style scoped></style>