<template>
  <div class="foods">
    <scroll class="food-content">
      <div>
        <div
          v-for="(item, i) in foodsList"
          :key="i"
          class="foodItem"
          :class="{ foodItemActive: currentIndex === i }"
          @click="change(i)"
        >
          <img :src="imagesList[i]" alt="" />
          <p>{{ item }}</p>
        </div>
      </div>
    </scroll>
  </div>
</template>

<script>
import Scroll from "./../../../components/scroll/Scroll.vue";
export default {
  name: "foodItems",
  components: { Scroll },
  data() {
    return {
      currentIndex: 0,
      foodsList: [
        "喜茶实验室",
        "当季限定",
        "人气必喝榜",
        "喜茶制冰",
        "热饮推荐",
        "果茶家族",
        "茗茶/乳茶",
        "波波家族",
        "纯茶",
        "加料",
        "共同抗议",
        "灵感提示",
      ],
      imagesList: [
        "./../../../assets/imgs/food/food1.png",
        "./../../../assets/imgs/food/food2.png",
        "./../../../assets/imgs/food/food3.png",
        "./../../../assets/imgs/food/food4.png",
        "./../../../assets/imgs/food/food5.png",
        "./../../../assets/imgs/food/food6.png",
        "./../../../assets/imgs/food/food7.png",
        "./../../../assets/imgs/food/food8.png",
        "./../../../assets/imgs/food/food9.png",
        "./../../../assets/imgs/food/food10.png",
        "./../../../assets/imgs/food/food11.png",
      ],
    };
  },
  methods: {
    change(i) {
      this.currentIndex = i;
      this.$emit("scrollToWant", i);
    },
  },
};
</script>

<style scoped>
.foods {
  text-align: center;
  width: 60px;
  background-color: rgb(224, 220, 220);
  font-size: 10px;
  color: #8f8c8c;
}
.food-content {
  position: absolute;
  top: 115px;
  bottom: 60px;
  overflow: hidden;
}
.foodItem {
  height: 60px;
  padding: 15px 3px;
}
.foodItemActive {
  border-left: 5px solid rgb(218, 120, 29);
}
.foods img {
  width: 20px;
}
</style>