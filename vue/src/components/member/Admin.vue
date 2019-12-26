<template>
  <table>
    <tr>
	<h1>관리자 화면</h1>
      <td>
      <legend><h3>비밀번호 </h3></legend>
      <h5>{{person.passwd}}</h5>
      <button @click.prevent="pwUpdate">수정</button><br/><br/>
      </td>
    </tr>
    <tr>
      <td><legend><h3>학생부 관리</h3></legend>
      <h5>{{person.hak}} 학년</h5>
      <h5>{{person.ban}} 반</h5>
      <h5>{{person.score}}점</h5>
      <br/>
      <button @click.prevent="goUpdate">수정</button>
      </td>
    </tr>
  </table>
</template>
<script>
import { store } from "../../store";

export default {
  data(){
    return{
      context: 'http://localhost:8080/',
      name: store.state.name,
      person: store.state.person,
      authCheck : true
    }
  },
  methods: {
    pwUpdate(){

    },
    goUpdate(){
       this.$router.push({path:'/mypageupdate'})
    }
  }
}
</script>
<style scoped>

.back {width: 700px; margin: 0 ;}
    .sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
    .pull-left {float: left;}
    .pull-right {float: right;}
    .top {margin-top: 1%;}
    .rt {margin-right: 1%;}
    .size {width: 49.5%; height: 100%;}
</style>