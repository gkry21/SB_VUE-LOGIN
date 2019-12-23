<template>
<div Class="join">
	<h1>조인 화면</h1>
	<div class="form-group">
            <input type="text" v-model="userid" class="form-control" placeholder="id" required="required">
        </div>
        <div class="form-group">
            <input type="password" v-model="passwd" class="form-control" placeholder="password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" @click.prevent="join" class="btn btn-primary btn-block">회원 가입</button>
        </div>
</div>
</template>
<script>
import axios from 'axios'
import {store} from "../../store"
export default {
	data(){
		return{
			userid: '',
			passwd: ''
		}
	},
	methods: {
		join(){
			alert(`${this.userid}, ${this.passwd}`)
			let url = `${this.context}/join`
			let data = {
				userid: this.userid,
				passwd: this.passwd
			}
			let headers = {
'authorization': 'JWT fefege..',
'Accept' : 'application/json',
'Content-Type': 'application/json'
}
			axios
			.post(url, data, headers)
			.then(()=>{
				alert("AXIOS 성공")
				store.state.userid = this.userid
				store.state.passwd = this.passwd
			})
			.catch(()=>{
				alert('AXIOS 실패')
			})
		}
	}
}
</script>
<style scoped>
</style>