<template>
  <div class="food">
    <div :class="{ changeBgc: foodactive }"></div>
    <food-top />
    <food-items @scrollToWant="changeScrollTo" />
    <!-- <food-items /> -->
    <scroll class="food-content" :probe-type="3" ref="scroll">
      <div>
        <foods ref="foods" @addMban="add" />
      </div>
    </scroll>
    <m-ban
      :foodData="foodList"
      :nowTime="time"
      :num="num"
      @addCart="addCart"
    />
    <food-cart
      :foodData="foodList"
      :nowTime="time"
      :num="num"
    />
  </div>
</template>

<script>
import Scroll from "./../../components/scroll/Scroll.vue";
import FoodCart from "./childComps/foodCart.vue";
import FoodItems from "./childComps/foodItems.vue";
import Foods from "./childComps/foods.vue";
import foodTop from "./childComps/foodTop.vue";
import MBan from "./childComps/mBan.vue";
//import {getSliderList,getCateqgory} from 'network/index'
export default {
  name: "Food",
  components: {
    foodTop,
    FoodItems,
    Scroll,
    Foods,
    MBan,
    FoodCart,
  },
  created(){
  //  this.getData()
  },
  data() {
    return {
      foodList: {},
      num: -1,
      price: 0,
      time: "",
      foodactive: false,
      // cartListShow:false,
      // cartLists: {
      //   foodNames: [],
      //   foodPrices: [],
      //   foodNums: 0,
      // },
    };
  },
  methods: {
    // getData(){
    //   getSliderList().then(res=>{
    //     console.log(res);
    //   }).catch(err=>{

    //   })
    //   getCateqgory({
    //     ategory_id: "1"
    //   }).then(res=>{

    //   }).catch(err=>{

    //   })
    // },
    changeScrollTo(i) {
      let highs = this.$refs.foods.highs;
      let high = 0;
      for (let j = 0; j < highs.length; j++) {
        if (j === i) {
          high = highs[i];
          this.$refs.scroll.scrollTo(0, -high, 300);
        }
      }
    },

    add(foodList, i) {
      this.foodList = foodList;
      this.num = i;
      this.time = new Date().getTime().toString();

      let obj = {};
      obj.imgs = foodList.imgs[i];
      obj.foodName = foodList.foodNames[i];
      obj.foodPrice = foodList.prices[i];
      //this.$store.commit("addCart", obj);
    },

    addCart(price) {
      this.price = price;
    },

    changeBgc() {
      this.foodactive = !this.foodactive;
      // console.log(111);
    },
  },
};
</script>

<style scoped>
.food {
  height: 100vh;
}
/* .changeBgc {
  width: 100%;
  height: 100vh;
  background-color: rgb(178, 178, 178, 0.5);
  opacity: 0.5;
} */
.food-content {
  position: absolute;
  top: 115px;
  bottom: 60px;
  left: 60px;
  overflow: hidden;
  margin: 5px;
  margin-top: 0;
  /* background-color: red; */
}
</style>