<template>
  <div class="foods">
    <div class="food-content">
      <div
        v-for="(item, i) in classList"
        :key="i"
        class="foodItem"
        :class="{ foodItemActive: currentIndex === i }"
        @click="change(i)"
      >
        <p>{{ item.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '/src/request/index.js';
export default {
  name: "foodItems",
  created() {
    axios.get('/cla/list', {})
    .then((res) => {
      // console.log(res);
        this.classList = res.data.data.class;
    })
    .catch((err) => {
        console.log(err);
    });
  },
  data() {
    return {
      currentIndex: 0,
      classList: [],
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
  width: 70px;
  font-size: 10px;
  color: #8f8c8c;
}
.food-content {
  position: absolute;
  width: 80px;
  top: 115px;
  bottom: 50px;
  padding-bottom: 50px;
  overflow: scroll;
  background-color: rgba(0, 0, 0, 0.05);
}
.foodItem {
  width: 70px;
  height: 60px;
  line-height: 60px;
  text-align: left;
  padding-left: 5px;
}
.foodItemActive {
  border-left: 5px solid rgb(218, 120, 29);
  background-color: white;
}
</style>