<template>
  <div class="cart" v-if="num !== -1">
    <img
      :class="{ activeImg: 'isActive' }"
      src="./../../../assets/imgs/food/cart.png"
      alt=""
      @click="cartImgClick"
    />
    <p>￥{{ allPrice }}</p>
    <!-- <div @click="$router.push('/orderPay')" class="right">结算</div> -->
    <div class="right">结算</div>
    <div class="cartlists" v-show="isShow">
      <div class="top">
        <div class="t-left">
          <span
            class="checkbox"
            :class="{ checkboxActive: isAll }"
            @click="isAllSelect"
          ></span
          ><span>全选</span>
        </div>
        <div class="t-right">清理购物车</div>
      </div>
      <div class="foods" v-for="(item, i) in payList" :key="i">
        <span
          class="inp"
          :class="{ inpActive: item.checked }"
          @click="
            {
              item.checked = !item.checked;
            }
          "
        ></span>
        <img :src="item.imgs" alt="" />
        <div class="text">
          <div>{{ item.foodName }}</div>
          <div class="ntwo">￥{{ item.foodPrice }}</div>
        </div>
        <div class="foods-right">
          <span class="sub" @click="subFood(i)">-</span>
          <span>{{ item.count }}</span>
          <span class="add" @click="addFood(i)">+</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "foodCart",
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
      isAll: true,
    };
  },
  methods: {
    cartImgClick() {
      this.isShow = !this.isShow;
      this.$emit("changeBgc");
    },
    addFood(i) {
      //this.$store.getters.cartList[i].count++;
    },
    subFood(i) {
      // if(this.$store.getters.cartList[i].count>0){
      //   this.$store.getters.cartList[i].count--;
      // }

    },
    isAllChange() {
      this.isAll = !this.isAll;
    },
    // isAllSelect() {
    //   this.isAll = !this.isAll;
    //   let isAll = this.$store.getters.cartList.find((item) => !item.checked);
    //   if (isAll) {
    //     this.$store.getters.cartList.forEach((item) => {
    //       item.checked = true;
    //     });
    //   } else {
    //     this.$store.getters.cartList.forEach((item) => {
    //       item.checked = false;
    //     });
    //   }
    // },
  },
  computed: {
    payList() {
      return //this.$store.getters.cartList;
    },
    payCount() {
      return //this.$store.getters.getLength;
    },
    allPrice() {
      let pri = 0;
      // for (var item of this.$store.getters.cartList) {
      //   pri = pri + item.checked * item.count * item.foodPrice;
      // }
      return pri;
    },
  },
};
</script>


<style scoped>
.cart {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100px;
  background-color: rgb(214, 205, 205);
}
.cart > img {
  position: absolute;
  width: 40px;
  left: 15px;
  border-radius: 100%;
  box-shadow: 3px 3px 3px #888888;
}
.activeImg {
}
.checkbox {
  display: inline-block;
  width: 10px;
  height: 10px;
  border: 1px solid #000;
  border-radius: 100%;
}
.checkboxActive {
  background-color: rgb(116, 111, 111);
}
.inp {
  display: inline-block;
  width: 10px;
  height: 10px;
  border: 1px solid #000;
  border-radius: 100%;
}
.inpActive {
  background-color: rgb(116, 111, 111);
}
.inp {
  float: left;
  margin: 20px 10px 0px 10px;
}
.cart p {
  position: absolute;
  left: 70px;
  display: inline-block;
  height: 100px;
  line-height: 50px;
  /* line-height: 100px; */
  color: #000;
}
.right {
  float: right;
  width: 80px;
  height: 100px;
  line-height: 50px;
  background-color: rgb(226, 128, 36);
  text-align: center;
  color: #fff;
}
.cartlists {
  width: 100%;
  background-color: #fff;
  position: absolute;
  bottom: 100px;
  left: 0;
  padding: 10px;
}
.cartlists .top {
  height: 30px;
}
.cartlists .top .t-left {
  float: left;
}
.cartlists .top .t-left span {
  margin-left: 10px;
  font-size: 15px;
}
.cartlists .top .t-right {
  float: right;
  font-size: 10px;
  color: rgb(136, 133, 133);
}
.foods {
  width: 100%;
  height: 80px;
  padding: 15px 0px 15px 0px;
  font-size: 15px;
  color: #000;
}
.foods img {
  width: 60px;
  height: 60px;
  float: left;
}
.foods .text {
  float: left;
  margin-left: 20px;
}
.text div {
  margin-top: 5px;
}
.text .ntwo {
  margin-top: 15px;
}
.foods-right {
  float: right;
}
.foods-right span {
  margin: 30px 5px 0px 5px;
}
.foods-right .add,
.sub {
  display: inline-block;
  width: 15px;
  height: 15px;
  line-height: 15px;
  border-radius: 100%;
  text-align: center;
}
.foods-right .sub {
  background-color: rgb(136, 133, 133);
}
.foods-right .add {
  background-color: rgb(226, 128, 36);
}
</style>