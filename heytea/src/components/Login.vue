<template>
    <div v-if="show" id="login">
        <div class="login-box">
            <div class="login-box-inner">
                <div class="login-title" v-if="title">{{title}}</div>
                <div class="login-content">{{content}}</div>
                <div class="login-input">
                    <span>账号</span><input type="text" class="username" /><br>
                    <span>密码</span><input type="password" class="password" />
                </div>
            </div>
            <div class="login-box-buttons">
                <router-link to="/forget" class="link">忘记密码</router-link>
                <router-link to="/register" class="link">注册</router-link>
                <span class="login-btn-success" @click="success">{{submitText}}</span>
                <span class="login-btn-cancel" @click="cancel">{{cancelText}}</span>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'Login',
        data () {
            return {
                name:'login-comfirm',
                title: '登录',
                show: false,
                content: '请输入您的账号和密码',
                submitText: '确定',
                cancelText: '取消'
            }
        },
        methods: {
            open() {
                this.show = true;
            },
            success () {
                this.show = false;
            },
            cancel () {
                this.show = false;
            }
        }
    }
</script>
<style scoped>
#login {
    background: rgba(00, 00, 00, 0.5);
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    z-index: 9;
}
#login .login-box {
    width: 80%;
    max-width: 400px;
    top: 200px;
    position: absolute;
    left: 0;
    right: 0;
    margin: auto;
    background: #fff;
    box-sizing: border-box;
    padding: 20px;
    border-radius: 6px;

}
#login .login-box .login-box-inner .login-title {
    padding-left: 10px;
    margin-bottom: 0;
    font-size: 18px;
    font-weight: 700;
    height: 18px;
    color: #333;
}
#login .login-box .login-box-inner .login-content {
    padding: 10px 0 0 10px;
    line-height: 24px;
    color: #48576a;
    font-size: 12px;
}
#login .login-box .login-box-inner .login-input {
    padding: 10px;
    text-align: left;
    line-height: 40px;
}
#login .login-box .login-box-inner .login-input span {
    color: #333;
    font-size: 14px;
}
#login .login-box .login-box-buttons .link {
    font-size: 14px;
    color: #48576a;
    margin: 0 10px;
    text-decoration: none;
}
#login .login-box .login-box-buttons .login-btn-success {
    background: #20a0ff;
    border-color: #20a0ff;
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    color: #fff;
    margin: 0 5px 0 30px;
    padding: 10px 15px;
    border-radius: 4px;
}
#login .login-box .login-box-buttons .login-btn-cancel {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #fff;
    border: 1px solid #c4c4c4;
    color: #1f2d3d;
    margin: 0;
    padding: 10px 15px;
    border-radius: 4px;
}
</style>
