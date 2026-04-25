document.querySelector('#form-busca').onsubmit = function() {
	if (document.querySelector('#q').value == '') {
		document.querySelector('#form-busca').style.background = 'red';
		return false;
	}
}

var banners = ["assets/img/destaque-home.png", "assets/img/destaque-home-2.png"];

var bannerAtual = 0;

function trocarBanner(){
	bannerAtual = (bannerAtual + 1) % 2;

	document.querySelector('.destaque img').src = banners[bannerAtual];
}

setInterval(trocarBanner, 4000);