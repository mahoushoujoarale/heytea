<template>
  <div class="foods">
    <img src="./../../../assets/imgs/food/ad1.png" alt="" />
    <img src="./../../../assets/imgs/food/ad2.png" alt="" />
    <div class="cla" v-for="(itemcla, icla) in classList" :key="icla">
      <p>{{ itemcla.name }}</p>
      <div class="foodList" v-for="(item, i) in itemcla.drinks" :key="i">
        <div class="name">{{ item.name }}</div>
        <div class="img"><img :src="item.images[0]" alt="" /></div>
        <span v-show="item.tags[0]">{{ item.tags[0] }}</span>
        <span v-show="item.tags[1]">{{ item.tags[1] }}</span>
        <p>{{ item.des }}</p>
        <div class="price">￥{{ item.price }}</div>
        <div @click="add(item)" class="add">+</div>
      </div>
    </div>
    <div class="last">别刷了，已经到底了</div>
  </div>
</template>

<script>
import axios from '/src/request/index.js';
export default {
  name: "foods",
  created() {
    axios.get('/cla/list', {})
    .then((res) => {
        this.classList = res.data.data.class;
    })
    .catch((err) => {
        console.log(err);
    });
    axios.get('/drink/list', {})
    .then((res) => {
        this.foodList = res.data.data.drink;
        for (let item1 of this.classList) {
          item1.drinks = this.foodList.filter(item => item.cla === item1.name);
        };
    })
    .catch((err) => {
        console.log(err);
    })
  },
  data() {
    return {
      highs: [],
      classList: [],
      foodList: [],
    };
  },
  methods: {
    add(food) {
      this.$emit("addMban", food);
    },
  },
};
</script>

<style scoped>
.foods {
  /* padding: 0, 5px, 50px, 0; */
  margin-left: 15px;
}
.foods > img {
  width: 100%;
  height: 150px;
}
.foods .cla p {
  font-size: 8px;
  margin-top: 15px, 15px;
  margin: 15px;
  color: #8f8c8c;
}
.foodList {
  padding: 10px;
  margin-bottom: 40px;
}
.foodList .name {
  /* display: inline-block; */
  margin-left: 60px;
  font-size: 15px;
}
.foodList .img {
  width: 80px;
  height: 80px;
  float: left;
  margin-right: 10px;
  border-radius: 6px;
  overflow: hidden;
  text-align: center;
}
.foodList .img > img {
  margin-left: -30px;
  width: 140px;
  height: 80px;
}
.foodList span {
  display: inline-block;
  padding: 4px;
  background-color: rgb(224, 220, 220);
  font-size: 5px;
  margin-right: 10px;
  margin-top: 10px;
}
.foodList p {
  font-size: 8px;
  height: 32px;
  overflow: hidden;
  text-overflow: ellipsis;
}
.foodList .price {
  font-weight: bold;
  float: left;
}
.foodList .add {
  float: right;
  width: 20px;
  height: 20px;
  line-height: 20px;
  background-color: rgb(218, 120, 29);
  text-align: center;
  font-size: 20px;
  border-radius: 100%;
  color: #fff;
}
.foods .last {
  padding-top: 60px;
  color: rgb(224, 220, 220);
  font-size: 12px;
  text-align: center;
}
</style>