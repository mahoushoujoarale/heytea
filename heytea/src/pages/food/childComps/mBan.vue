<template>
  <div v-if="isShow">
    <div class="mBan"></div>
    <div class="main">
      <span class="close" @click="closeFn">X</span>
      <img :src="foodData.imgs[num]" alt="" />
      <div class="text">
        <div class="name">{{ foodData.foodNames[num] }}</div>
        <span v-show="foodData.exps1[num]">{{ foodData.exps1[num] }}</span>
        <span v-show="foodData.exps2[num]">{{ foodData.exps2[num] }}</span>
        <p>产品描述</p>
        <p>{{ foodData.texts[num] }}</p>
      </div>
      <div class="bottom">
        <div class="price">￥{{ foodData.prices[num] }}</div>
        <div class="right">
          <span @click="subFood(i)">-</span>
          <div>1</div>
          <span @click="addFood(i)">+</span>
        </div>
      </div>
      <button @click="sure">确定</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    foodData: {
      type: Object,
      default() {
        return {};
      },
    },
    num: Number,
    nowTime: String,
  },
  data() {
    return {
      isShow: false,
    };
  },
  mounted() {},
  name: "mBan",
  methods: {
    closeFn() {
      this.isShow = false;
    },
    sure() {
      this.isShow = false;
      this.$emit("addCart", this.foodData.prices[this.num]);
    },
    addFood(i) {
      //this.$store.getters.cartList[i].count++;
    },
    subFood(i) {
      // if(this.$store.getters.cartList[i].count>0){
      //   this.$store.getters.cartList[i].count--;
      // }

    },
  },
  watch: {
    nowTime: {
      handler(newValue, oldValue) {
        // console.log(newValue, oldValue);
        // if (newValue !== -1) this.isShow = true;
        this.isShow = true;
      },
    },
  },
};
</script>


<style scoped>
.mBan {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgb(153, 152, 152);
  opacity: 0.3;
}
.main {
  width: 300px;
  height: 430px;
  background-color: #fff;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  border-radius: 10px;
}
.main .close {
  position: absolute;
  right: 10px;
  top: 10px;
  width: 15px;
  height: 15px;
  line-height: 15px;
  background-color: rgb(134, 133, 133);
  text-align: center;
  font-size: 13px;
  border-radius: 100%;
  color: #fff;
}
.main .text {
  position: absolute;
  left: 10px;
  top: 170px;
  /* border-bottom: 0.2px solid rgb(155, 152, 152); */
}
.main img {
  width: 150px;
  margin-top: 20px;
  position: absolute;
  top: 0;
  left: 50%;
  margin-left: -75px;
}
.main .name {
  font-size: 15px;
  color: rgb(10, 10, 10);
  margin-bottom: 5px;
}
.text span {
  display: inline-block;
  padding: 4px;
  background-color: rgb(224, 220, 220);
  font-size: 5px;
  margin-right: 10px;
}
.main p {
  font-size: 8px;
  color: rgb(124, 122, 122);
  margin-top: 5px;
}
.bottom {
  position: absolute;
  bottom: 70px;
  width: 100%;
}
.bottom div {
  display: inline-block;
}
.bottom .price {
  float: left;
  margin-left: 10px;
  font-size: 15px;
  color: rgb(10, 10, 10);
}
.bottom .right {
  float: right;
}
.right span {
  display: inline-block;
  width: 15px;
  height: 15px;
  line-height: 15px;
  border-radius: 100%;
  background-color: rgb(226, 128, 36);
  text-align: center;
  font-size: 20px;
  margin: 0px 5px 0 5px;
}
button {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  display: inline-block;
  width: 270px;
  height: 30px;
  background-color: rgb(226, 128, 36);
  margin: 0 auto;
  border-radius: 4px;
  color: #fff;
}
</style>