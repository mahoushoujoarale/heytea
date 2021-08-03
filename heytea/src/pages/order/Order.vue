<template>
  <div class="order">
    <div class="order-header">
      <div
        class="nowOrder"
        :class="order_active === 0 ? 'order-active' : ''"
        @click="changeTab(0)"
      >
        当前订单
      </div>
      <div
        class="historyOrder"
        :class="order_active === 1 ? 'order-active' : ''"
        @click="changeTab(1)"
      >
        历史订单
      </div>
    </div>
    <div v-if="order_active === 0" class="order-content">
      <orderItem :status="true"></orderItem>
    </div>
    <div v-if="order_active === 1" class="history-content">
      <orderItem :status="true"></orderItem>
      <orderItem :status="true"></orderItem>
      <orderItem :status="false"></orderItem>
    </div>
    <div class="footer">没有更多了</div>
  </div>
</template>

<script>
//import {getOrderList} from 'network/index'
import orderItem from "./childCom/orderItem.vue";
export default {
  name: "Order",
  components: {
    orderItem,
  },
  data() {
    return {
      order_active: 0,
    };
  },
  // created(){
  //   getOrderList({
  //     user_id:1
  //   }).then(res=>{
  //     console.log(res);
  //   }).catch(err=>{

  //   })
  // },
  methods: {
    changeTab(index) {
      this.order_active = index;
    },
  },
};
</script>

<style scoped>
.order {
  background-color: rgb(245, 245, 245);
  min-height: 100%;
}
.order-header {
  display: flex;
  position: fixed;
  top: 0;
  width: 100%;
  height: 80px;
  background-color: #fff;
}
.order-header div {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}
.order-active {
  color: orange;
  border-bottom: 5px solid orange;
}
.order-content {
  padding-top: 100px;
}
.history-content {
  padding-top: 100px;
}
.footer {
  text-align: center;
  margin-top: 30px;
  padding-bottom: 80px;
  color: rgb(180, 173, 173);
  font-size: 16px;
}
</style>