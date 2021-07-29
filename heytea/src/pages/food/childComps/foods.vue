<template>
  <div class="foods">
    <img src="./../../../assets/imgs/food/ad1.png" alt="" />
    <img src="./../../../assets/imgs/food/ad2.png" alt="" />
    <p ref="p1">喜茶实验室</p>
    <div class="foodList1" v-for="(item, i) in foodList1.imgs" :key="i">
      <div class="name">{{ foodList1.foodNames[i] }}</div>
      <img :src="foodList1.imgs[i]" alt="" />
      <!-- <img src="./../../../assets/imgs/food/f1.png" alt="" /> -->
      <span v-show="foodList1.exps1[i]">{{ foodList1.exps1[i] }}</span>
      <span v-show="foodList1.exps2[i]">{{ foodList1.exps2[i] }}</span>
      <p>{{ foodList1.texts[i] }}</p>
      <div class="price">￥{{ foodList1.prices[i] }}</div>
      <div @click="add(foodList1, i)" class="add">+</div>
    </div>
    <p ref="p2">当季限定</p>
    <div class="foodList1" v-for="(item, i) in foodList2.imgs" :key="i">
      <div class="name">{{ foodList2.foodNames[i] }}</div>
      <img :src="foodList2.imgs[i]" alt="" />
      <p>{{ foodList2.texts[i] }}</p>
      <div class="price">￥{{ foodList2.prices[i] }}</div>
      <div @click="add(foodList2, i)" class="add">+</div>
    </div>
    <p ref="p3">人气必喝榜</p>
    <div class="foodList1" v-for="(item, i) in foodList3.imgs" :key="i">
      <div class="name">{{ foodList3.foodNames[i] }}</div>
      <img :src="foodList3.imgs[i]" alt="" />
      <p>{{ foodList3.texts[i] }}</p>
      <div class="price">￥{{ foodList3.prices[i] }}</div>
      <div @click="add(foodList3, i)" class="add">+</div>
    </div>
    <p ref="p4">喜茶制冰</p>
    <div class="foodList1" v-for="(item, i) in foodList4.imgs" :key="i">
      <div class="name">{{ foodList4.foodNames[i] }}</div>
      <img :src="foodList4.imgs[i]" alt="" />
      <p>{{ foodList4.texts[i] }}</p>
      <div class="price">￥{{ foodList4.prices[i] }}</div>
      <div @click="add(foodList4, i)" class="add">+</div>
    </div>
  </div>
</template>

<script>
import mBan from "./mBan.vue";
export default {
  components: { mBan },
  name: "foods",
  mounted() {
    // this.$nextTick(() => {
    //   this.highs.push(this.$refs.p1.offsetTop);
    //   this.highs.push(this.$refs.p2.offsetTop);
    //   this.highs.push(this.$refs.p3.offsetTop);
    //   this.highs.push(this.$refs.p4.offsetTop);
    // });
  },
  data() {
    return {
      highs: [],
      foodList1: {
        imgs: [
          "./../../../assets/imgs/food/f1.png",
          "./../../../assets/imgs/food/f2.png",
          "./../../../assets/imgs/food/f3.png",
          "./../../../assets/imgs/food/f4.png"
        ],
        foodNames: ["芒芒甘露冰棒", "火腿蛋可松脆堡", "夹心小方", "NFC芒芒汁"],
        exps1: ["新品", "含小麦、燕麦、蛋", "含乳制品"],
        exps2: ["含乳制品", "乳及大豆制品"],
        texts: [
          "人气多肉芒芒甘露变身冰棒。爽口芒芒冰壳中夹有爱文芒果果肉与酸甜",
          "可颂面包夹入大块烟熏火腿与原味蛋饼，车打芝士更添浓郁奶香",
          "10片/盒，每片均为独立小包装，芝士味、咸蛋黄味2款可选。精选美...",
          "非浓缩还原，0脂肪，0添加剂，纯粹鲜榨，不加一滴水。大颗芒果鲜榨...",
        ],
        prices: [18, 19, 45, 19],
      },
      foodList2: {
        imgs: [
          "./../../../assets/imgs/food/f5.png",
          "./../../../assets/imgs/food/f6.png",
          "./../../../assets/imgs/food/f7.png"
        ],
        foodNames: ["芒芒甘露椰椰冻", "生打椰椰奶冻", "生打椰椰芒"],
        exps1: [],
        exps2: [],
        texts: [
          "冷500ml椰椰冰淇淋打顶，优质生椰乳与芒芒冰沙轻轻滑过舌尖，再加...",
          "冷/热500ml。仅选用优质生椰乳，保留椰子原始风味。椰香浓厚，质...",
          "10片/冷/热500ml。仅选用优质生椰乳，保留椰子原始风味。椰香浓厚，质......",
        ],
        prices: [29, 25, 25],
      },
      foodList3: {
        imgs: [
          "./../../../assets/imgs/food/f8.png",
          "./../../../assets/imgs/food/f9.png",
          "./../../../assets/imgs/food/f10.png"
        ],
        foodNames: ["多肉葡萄", "多肉芒芒甘露", "芝芝梅梅"],
        exps1: [],
        exps2: [],
        texts: [
          "冷670ml热500ml人气Top1当季巨峰葡萄回归，颗颗剁手，保留果肉...",
          "冷/热标准杯500ml冷加大MAX杯670ml人气Top2经典芒芒与杨枝甘露...",
          "冷670ml热500ml人气Top3选用定制草莓搭配绿妍茶底新鲜现打，莓...",
        ],
        prices: [29, 27, 32],
      },
      foodList4: {
        imgs: [
          "./../../../assets/imgs/food/f11.png",
          "./../../../assets/imgs/food/f12.png",
          "./../../../assets/imgs/food/f13.png"
        ],
        foodNames: ["椰椰脆冻", "芝芝脆冻", "椰椰冻雪糕杯"],
        exps1: [],
        exps2: [],
        texts: [
          "由于冰淇淋易化，下单后需要到冰淇淋机出示购买凭证制作领取，敬请谅解...",
          "由于冰淇淋易化，下单后需要到冰淇淋机出示购买凭证制作领取，敬请谅解...",
          "10片/由于冰淇淋易化，下单后需要到冰淇淋机出示购买凭证制作领取，敬请谅解......",
        ],
        prices: [9, 9, 13],
      },
    };
  },
  methods: {
    add(foodList, i) {
      this.$emit("addMban", foodList, i);
    },
  },
};
</script>

<style scoped>
.foods {
  padding: 0, 5px, 5px, 5px;
}
.foods img {
  width: 100%;
  height: 150px;
}
.foods p {
  font-size: 8px;
  margin-top: 15px, 15px;
  margin: 15px;
  color: #8f8c8c;
}
.foodList1 {
  padding: 10px;
  margin-bottom: 30px;
}
.foodList1 .name {
  /* display: inline-block; */
  margin-left: 60px;
  font-size: 15px;
}
.foodList1 img {
  width: 50px;
  height: 80px;
  float: left;
  margin-right: 10px;
}
.foodList1 span {
  display: inline-block;
  padding: 4px;
  background-color: rgb(224, 220, 220);
  font-size: 5px;
  margin-right: 10px;
  margin-top: 10px;
}
.foodList1 p {
  font-size: 8px;
}
.foodList1 .price {
  font-weight: bold;
  float: left;
}
.foodList1 .add {
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
</style>