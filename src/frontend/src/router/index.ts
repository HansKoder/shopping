import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

// Views
import HomeView from "../views/HomeView.vue";
import ClothesView from "../views/ClothesView.vue";
import DetailClothesVue from "@/views/clothes/DetailClothes.vue";

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
    component: DetailClothesVue,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
