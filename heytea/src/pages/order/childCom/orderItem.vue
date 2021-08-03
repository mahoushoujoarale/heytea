<template>
    <div class="order-content" style="padding: 0 8px;">
        <div class="content-header" @click="$router.push('/orderdetail')">
            <div class="header-left">
                <div class="title">悠方购物中心</div>
                <div class="time">2020-10-22 16：19：20</div>
            </div>
            <div class="header-right">
                <div class="complete" >{{status?"已完成":"已取消"}}</div>
            </div>
        </div>
        <div class="content-middle" @click="$router.push('/orderdetail')">
            <div class="middle-left">
                <img src="/src/assets/imgs/order/ice-img.png"/>
            </div>
            <div class="middle-right">
                <div class="price">￥ 18</div>
                <div class="num">共 1 件</div>
            </div>
        </div>
        <div class="content-btn">
            <div class="invoice" @click="$router.push('/orderdetail')">开发票</div>
            <div class="again" @click="$router.push('/food')">再来一单</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "orderItem",
        props:{
            status:false
        }
    }
</script>

<style scoped>
    .order-content{
        background: #fff;
        height: 230px;
        margin-bottom: 20px;
    }
    .order-header div{
        flex:1;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .content-header{
        height: 70px;
    }
    .content-header .header-left{
        margin-top: 30px;
        margin-left: 10px;
        float: left;
    }
    .content-header .header-right{
        margin-top: 30px;
        margin-right:20px;
        float: right;
    }
    .content-header .header-left .title{
        font-size: 14px;
        color: #333333;
    }
    .content-header .header-left .time{
        font-size: 14px;
        color: #999999;
    }
    .content-header .header-right .complete{
        color: #999999;
    }

    .content-middle{
        height: 90px;
    }
    .content-middle .middle-left{
        float: left;
    }
    .content-middle .middle-left img{
        display: inline-block;
        width: 80px;
        height: 80px;
    }
    .content-middle .middle-right{
        float: right;
        margin-right: 15px;
        font-size: 16px;
    }
    .content-middle .middle-right .price{
        margin-top: 50px;
        color: #333333;
    }
    .content-middle .middle-right .num{
        color: #999999;
        font-size: 15px;
    }
    .content-btn{
        height: 30px;
        margin-top: 20px;
        position: absolute;
        right: 20px;
    }
    .content-btn .invoice{
        text-align: center;
        line-height: 30px;
        padding: 0 15px;
        display: inline-block;
        height: 30px;
        border: 1px solid skyblue;
        margin-right: 10px;
        border-radius: 5px;
    }
    .content-btn .again{
        display: inline-block;
        text-align: center;
        line-height: 30px;
        padding: 0 10px;
        height: 30px;
        border: 1px solid orange;
        color: orange;
        border-radius: 5px;
    }
    .footer{
        text-align: center;
        height: 296px;
        margin-top: 20px;
    }
</style>