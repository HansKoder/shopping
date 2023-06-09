import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

// Views
import HomeView from "../views/HomeView.vue";

// Views of Clothes
import ClothesView from "../views/ClothesView.vue";
import DetailClothesView from "@/views/clothes/DetailClothes.vue";
import AddClothesView from "@/views/clothes/AddClothes.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/clothes",
    name: "clothes",
    component: ClothesView,
  },
  {
    path: "/clothes/detail/:id",
    name: "detailClothes",
    component: DetailClothesView,
  },
  {
    path: "/clothes/add",
    name: "addClothes",
    component: AddClothesView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
