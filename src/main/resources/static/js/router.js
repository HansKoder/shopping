const route = (event) => {
    event = event || window.event;
    event.preventDefault();
    window.history.pushState({}, "", event.target.href);
    handleLocation();
  };
  
  const routes = {
    404: "/pages/404.html",
    "": "/pages/index.html",
    "#": "/pages/index.html",
    "#purchase": "/pages/purchase.html",
    "#about": "/pages/about.html",
    "#clothes": "/pages/clothes.html"
  };
  
  const handleLocation = async () => {
    const path = window.location.hash;
    console.log('path ', path);

    const route = routes[path] || routes[404];
    console.log('route ', route)

    const oldHtml = document.getElementById("main-page").innerHTML;

    const html = await fetch(route)
      .then((data) => data.text())
      .catch((_) => oldHtml);
    document.getElementById("main-page").innerHTML = html;
  };
  
  window.onpopstate = handleLocation;
  window.route = route;
  
  handleLocation();
 
