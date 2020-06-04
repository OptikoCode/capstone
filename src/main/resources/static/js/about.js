

let pics = new TimelineMax();

pics.from(".card-img-top", 2, {
    delay: 0.1,
    opacity: 0,
    y: -30,
    ease: Expo.ease
}).from(".card-img-top", 2, {
    delay: 0.1,
    opacity: 0,
    y: -30,
    ease: Expo.ease
}, "-=5");

let mainPara = new TimelineMax();

mainPara.from(".card-text", 2, {
    delay: 0.1,
    opacity: 0,
    x: 20,
    ease: Expo.easeOut
}).from(".card-text", 2, {
    delay: 0.1,
    opacity: 0,
    x: 20,
    ease: Expo.easeOut
}, "-=5");

let buttons = new TimelineMax();

buttons.from(".about-button", 2, {
    delay: 0.1,
    opacity: 0,
    x: -20,
    ease: Expo.easeOut
}).from(".about-button", 2, {
    delay: 0.1,
    opacity: 0,
    x: -20,
    ease: Expo.easeOut
}, "-=5");