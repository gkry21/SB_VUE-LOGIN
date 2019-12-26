<template>
<div Class="join">
	<h1>조인 화면</h1>
	<div class="form-group">
		아이디 <input type="text" v-model="userid" class="form-control" placeholder="id" required="required"><br/>
		비밀번호 <input type="password" v-model="passwd" class="form-control" placeholder="password" required="required"><br/>
		이름 <input type="text" v-model="name" class="form-control" placeholder="name" required="required"><br/>
		생일 <input type="text" v-model="birthday" class="form-control" placeholder="birthday" required="required"><br/>
		성별 <input type="text" v-model="gender" class="form-control" placeholder="W or N" required="required"><br/>
		학년 <input type="text" v-model="hak" class="form-control" placeholder="hak" required="required"><br/>
		반 <input type="text" v-model="ban" class="form-control" placeholder="ban" required="required"><br/>
		점수 <input type="text" v-model="score" class="form-control" placeholder="score" required="required"><br/>
		직급 <input type="text" v-model="roll" class="form-control" placeholder="roll" required="required"><br/>
		<button type="submit" @click.prevent="join" class="btn btn-primary btn-block">회원 가입</button>
  </div>
</div>
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return{
			context : 'http://localhost:8080',
			userid: '',
			passwd: '',
			name: '',
			birthday: '',
			gender: '',
			hak: '',
			ban: '',
			score: '',
			roll: ''
		}
	},
	methods: {
		join(){
			alert(`${this.userid},${this.passwd}`)
			let url = `${this.context}/join`
			let data = { userid : this.userid,
						passwd : this.passwd,
						name: this.name,
						birthday: this.birthday,
						gender: this.gender,
						hak: this.hak,
						ban: this.ban,
						score: this.score,
						roll: this.roll }
			let headers = {
			'authorization': 'JWT fefege..',
			'Accept' : 'application/json',
			'Content-Type': 'application/json'
			}
			axios
			.post(url, data, headers)
			.then(()=>{
				this.$router.push({path: '/login'})
			})
			.catch(()=>{
				alert('AXIOS 실패')
			})
		}
	}
}
</script>
<style scoped>
.form-group{
width:200px; margin: auto;
}
</style>