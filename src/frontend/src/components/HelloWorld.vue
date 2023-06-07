<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "HelloWorld",
  data() {
    return {
      msg: "",
    };
  },
  mounted() {
    try {
      const url = "http://127.0.0.1:8080/api/v1/messages/hello-world";
      fetch(url)
        .then((response) => response.text())
        .then((data) => {
          this.msg = data;
        });
    } catch (error) {
      console.log("Error ", error);
      this.msg = "";
    }
  },
});
</script>
