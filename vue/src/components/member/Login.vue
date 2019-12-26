<template>
	<div class="login-form">
    <form>
        <h2 class="text-center">아 로그인이라굽쇼</h2>       
        <div class="form-group">
            <input type="text" v-model="userid" class="form-control" placeholder="유우저네임이라굽쇼" required="required">
        </div>
        <div class="form-group">
            <input type="password" v-model="passwd" class="form-control" placeholder="비이밀번호라굽쇼" required="required">
        </div>
        <div class="form-group">
            <button type="submit" @click.prevent="login" class="btn btn-primary btn-block">할 수 있으면 해봐</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> 나를 기억해줘..☆</label>
            <a href="#" class="pull-right">비번 잊어먹었냐?</a>
        </div>        
    </form>
    <p class="text-center">
	<a>
		<router-link to="/join">계정  새로 만들래냐?</router-link>
	</a>
	</p>
</div>
</template>
<script>
import axios from 'axios'
import {store} from "../../store"
export default {
	data(){
		return{
			context: 'http://localhost:8080/',
			result: '',
			userid: '',
			passwd: '',
			person: {}
		}
	},
	methods: {
		login(){
			alert(`${this.userid} , ${this.passwd}`)
			let url = `${this.context}/login`
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
			.then(res=>{
				if(res.data.result === "SUCCESS"){
					store.state.loginedUid = this.person.userid
					store.state.loginedPw = this.person.passwd
					/* if(res.data.result===){} */
					alert(`로그인 성공 ${this.userid}`)
					this.person = res.data.person
					store.state.loginedUid = this.person.userid
					store.state.loginedPw = this.person.passwd
					store.state.id = this.person.id
					store.state.name = this.person.name
					store.state.birthday = this.person.birthday
					store.state.gender = this.person.gender
					store.state.hak = this.person.hak
					store.state.ban = this.person.ban
					store.state.score = this.person.score
					store.state.person = res.data.person
					store.state.loginstate = true
					alert(`스토어에 저장성공 ${store.state.name}`)
					this.$router.push({path:'/pagepick'})
				}else{
					alert(`로그인 실패`)
				}
			})
			.catch(()=>{
				alert('AXIOS 실패')
			})
		}
	}
}
</script>
<style scoped>
.login-form {
	width: 340px;
	margin: 50px auto;
}
.login-form form {
	margin-bottom: 15px;
	background: #f7f7f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.login-form h2 {
	margin: 0 0 15px;
}
.form-control, .btn {
	min-height: 38px;
	border-radius: 2px;
}
.btn {        
	font-size: 15px;
	font-weight: bold;
}
</style>