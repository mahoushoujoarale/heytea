<template>
  <div class="food">
    <food-top />
    <food-items/>
    <div class="food-content" :probe-type="3" ref="scroll">
      <foods ref="foods" @addMban="add" />
    </div>
    <m-ban
      v-if="MbanShow"
      :food='food'
      @addCart="addCart"
      @closeMban="closeMban"
    />
    <food-cart
      :food='food'
    />
  </div>
</template>

<script>
import FoodCart from "./childComps/foodCart.vue";
import FoodItems from "./childComps/foodItems.vue";
import Foods from "./childComps/foods.vue";
import foodTop from "./childComps/foodTop.vue";
import MBan from "./childComps/mBan.vue";
export default {
  name: "Food",
  components: {
    foodTop,
    FoodItems,
    Foods,
    MBan,
    FoodCart,
  },
  data() {
    return {
      food: {},
      foodactive: false,
      MbanShow: false,
    };
  },
  methods: {
    add(food) {
      this.food = food;
      this.MbanShow = true;
    },
    closeMban() {
      this.MbanShow = false;
    },
    addCart(food) {
      this.$store.dispatch("addcart", food);
    },
  },
};
</script>

<style scoped>
.food {
  width: 100%;
}
.food-content {
  position: absolute;
  top: 115px;
  bottom: 50px;
  left: 60px;
  overflow: scroll;
  margin: 5px;
  margin-top: 0;
}
</style>