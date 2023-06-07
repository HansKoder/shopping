module.exports = {
  devServer: {
    port: 3000,
    proxy: {
      "/api": {
        target: "http://localhost:8080/api/v1",
        ws: true,
        changeOrigin: true,
      },
    },
  },
};
