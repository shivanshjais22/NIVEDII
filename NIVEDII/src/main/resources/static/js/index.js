/**
 * 
 */
console.log("thise ")

console.log("this");
function toggleFunction() {
  if ($(".sidebar").is(":visible")) {
    // Sidebar is currently visible, so we're hiding it
    $(".sidebar").hide(200);
    $(".contain").css("margin-left", "0%");
  } else {
    // Sidebar is hidden, so we're showing it
    $(".sidebar").show(200);
    $(".contain").css("margin-left", "20%");
  }
  
  
};


const serch = ()=>{
	
	console.log("");
	
	let query=$("#serch-input").val();

	
	if(query==''){
		$(".serch-result").hide();
		
	}else{
		// sending request to server
		
		let url = `http://localhost:6212/serch/${query}`;
	
		fetch(url).then((response)=>{
		return response.json();
		})
		.then((data) => {
			console.log(data);
			
			let text = "<div class='list-group'>";

			  data.forEach((contact) => {
			      text += `<a href='/user/contact/${contact.cid}' class='list-group-item list-group-item-action'>
			                  ${contact.name}
			               </a>`;
			  });

			  text += "</div>";

			
			  $(".serch-result").html(text);
			            $(".serch-result").show();
			
		});
		
		console.log(query);
		$(".serch-result").show()
	}
}


//



function startTracking() {
	let map, marker;
  if (!map) {
    map = L.map('map').setView([20.5937, 78.9629], 5);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
    }).addTo(map);
    marker = L.marker([20.5937, 78.9629]).addTo(map);
  }

  const ws = new WebSocket("ws://localhost:8080/gps");

  ws.onopen = () => console.log("WebSocket connected");

  ws.onmessage = (event) => {
    try {
      const { lat, lon } = JSON.parse(event.data);
      console.log("Received GPS:", lat, lon);
      marker.setLatLng([lat, lon]);
      map.setView([lat, lon], 13);
    } catch (e) {
      console.error("Invalid message", e);
    }
  };

  ws.onerror = (err) => console.error("WebSocket error", err);
  ws.onclose = () => console.log("WebSocket closed");
}


