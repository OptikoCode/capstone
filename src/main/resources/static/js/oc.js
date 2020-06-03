$(document).ready(function() {

    // Summernote WYSIWYG
    $('.summernote').summernote({
        minHeight: 300,
        styleTags: [
            { title: 'Paragraph', tag: 'p' },
            { title: 'Blockquote', tag: 'blockquote', className: 'blockquote', value: 'blockquote' },
            'h1', 'h2', 'h3', 'h4', 'h5', 'h6'
        ],
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline']],
            ['mybutton', ['code']],
            ['misc', ['undo', 'redo']],
            ['view', ['codeview', 'help']]
        ],
        buttons: {
            code: function(context) {
                var ui = $.summernote.ui;

                var button = ui.button({
                    contents: 'code',
                    tooltip: 'Code Block',
                    click: function() {
                        context.invoke('editor.formatBlock', 'pre');
                    }
                });

                return button.render();
            }
        }
    });

    // Show video response form
    $('.add-video-response').click(function() {
        $('.video-response-form').slideDown('fast');
    });

    // Show comment form
    $('.add-comment').click(function() {
        $('.create-comment-form').slideDown('fast');
    });

    // Show/hide single comment/edit-comment-form
    $('.edit-comment-btn').click(function () {
        $(this).closest('.comment').removeClass('active');
        $(this).closest('.comment').next('.edit-comment').addClass('active');
    });


    // HOME PAGE JS AND GSAP

    const content = document.querySelector(".content");
    const left = document.querySelector(".left");
    const right = document.querySelector(".right");

    left.addEventListener('mouseenter', () => {
        content.classList.add('hover-left');
    })

    left.addEventListener('mouseleave', () => {
        content.classList.remove('hover-left');
    })

    right.addEventListener('mouseenter', () => {
        content.classList.add('hover-right');
    })

    right.addEventListener('mouseleave', () => {
        content.classList.remove('hover-right');
    });


    let leftHomeDiv = new TimelineMax();
    leftHomeDiv.from("#left", 2, {
        delay: 0.1,
        opacity: 0,
        x: -50,
        ease: Expo.ease
    }).from("#left", 2, {
        delay: 0.1,
        opacity: 0,
        x: -50,
        ease: Expo.ease
    }, "-=5");

    let rightHomeDiv = new TimelineMax();
    rightHomeDiv.from("#right", 2, {
        delay: 0.1,
        opacity: 0,
        x: 50,
        ease: Expo.ease
    }).from("#right", 2, {
        delay: 0.1,
        opacity: 0,
        x: 50,
        ease: Expo.ease
    }, "-=5");


    let t3 = new TimelineMax();
    t3.from("#home-o-letter", 1, { //will need to be id on home page
        delay: 0.77,
        opacity: 0,
        x: -70,
        ease: Expo.easeOut
    }).from(".home-button", 1, {
        delay: 0.77,
        opacity: 0,
        y: -70,
        ease: Expo.easeOut
    }).from("#home-c-letter", 1, {
        delay: 0.77,
        opacity: 0,
        x: 70,
        ease: Expo.easeOut
    }), "-=5";

    let leftPara = new TimelineMax();

    leftPara.from(".left-home-para", 2, {
        delay: 2.61,
        opacity: 0,
        y: 20,
        ease: Expo.easeIn
    }).from(".left-home-para", 2, {
        delay: 2.61,
        opacity: 0,
        y: 20,
        ease: Expo.easeIn
    }, "-=5");

    let rightPara = new TimelineMax();

    rightPara.from(".right-home-para", 2, {
        delay: 2.61,
        opacity: 0,
        y: 20,
        ease: Expo.easeIn
    }).from(".right-home-para", 2, {
        delay: 2.61,
        opacity: 0,
        y: 20,
        ease: Expo.easeIn
    }, "-=5");











    //REST OF GSAP

    let t1 = new TimelineMax();

    t1.from(".scircle", 3, {
        delay: 0.1,
        opacity: 0,
        y: 30,
        ease: Expo.easeInOut
    }).from(".circle", 3, {
        delay: 0.1,
        opacity: 0,
        y: 30,
        ease: Expo.easeInOut
    }, "-=4");

    let t2 = new TimelineMax();

    t2.from(".slide-right", 3, {
        delay: 0.1,
        opacity: 0,
        x: -40,
        ease: Expo.easeOut
    }).from(".slide-right", 3, {
        delay: 0.1,
        opacity: 0,
        x: -40,
        ease: Expo.easeOut
    }, "-=5");

    //triangle container and triangle divs inside
    gsap.timeline()
        .from(".triangle", {y: 160, stagger:0.1, duration:0.8, ease:"back"})
        .from(".triangle img", {y: 130, stagger:0.1, duration:0.8, ease:"back"})

    //diamond container and diamond divs inside
    gsap.timeline()
        .from(".diamond", {y: 160, stagger:0.1, duration:0.8, ease:"back"})
        .from(".diamond img", {y: 130, stagger:0.1, duration:0.8, ease:"back"})






    //JS SCREEN RECORDER

    var shareBtn = document.querySelector("button#shareScreen");
    shareBtn.onclick = shareScreen;

    var recBtn = document.querySelector("button#rec");
    recBtn.onclick = onBtnRecordClicked;

    var stopBtn = document.querySelector("button#stop");
    stopBtn.onclick = onBtnStopClicked;

    var videoElement = document.querySelector("video");
    videoElement.style.backgroundColor = "black";

    var downloadLink = document.querySelector("a#downloadLink");

    var mediaRecorder;
    var localStream = null;
    document.getElementById("error").innerHTML = "";

    function shareScreen(){
        console.log("shareScreen");
        document.getElementById("error").innerHTML = "";
        var screenConstraints = { video: true, audio: true };
        navigator.mediaDevices.getDisplayMedia(screenConstraints).then(function(screenStream){
            /* use the screen & audio stream */

            var micConstraints = {audio:true};
            navigator.mediaDevices.getUserMedia(micConstraints).then(function(micStream) {
                /* use the microphone stream */

                //create a new stream in which to pack everything together
                var composedStream = new MediaStream();

                //add the screen video stream
                screenStream.getVideoTracks().forEach(function(videoTrack) {
                    composedStream.addTrack(videoTrack);
                });

                //create new Audio Context
                var context = new AudioContext();

                //create new MediaStream destination. This is where our final stream will be.
                var audioDestinationNode = context.createMediaStreamDestination();

                //check to see if we have a screen stream and only then add it
                if (screenStream && screenStream.getAudioTracks().length > 0) {
                    //get the audio from the screen stream
                    const systemSource = context.createMediaStreamSource(screenStream);

                    //set it's volume (from 0.1 to 1.0)
                    const systemGain = context.createGain();
                    systemGain.gain.value = 1.0;

                    //add it to the destination
                    systemSource.connect(systemGain).connect(audioDestinationNode);

                }

                //check to see if we have a microphone stream and only then add it
                if (micStream && micStream.getAudioTracks().length > 0) {
                    //get the audio from the microphone stream
                    const micSource = context.createMediaStreamSource(micStream);

                    //set its volume
                    const micGain = context.createGain();
                    micGain.gain.value = 1.0;

                    //add it to the destination
                    micSource.connect(micGain).connect(audioDestinationNode);
                }

                //add the combined audio stream
                audioDestinationNode.stream.getAudioTracks().forEach(function(audioTrack) {
                    composedStream.addTrack(audioTrack);
                });

                //pass over to function that shows the stream and activates the recording controls
                onCombinedStreamAvailable(composedStream)

            }).catch(function(err) {
                console.log(err);
                document.getElementById("error").innerHTML = "You need a microphone to run screen recording";
            });
        }).catch(function(err) {
            console.log(err);
            document.getElementById("error").innerHTML = "You need to share your screen to run screen recording";
        });
    }

    function onCombinedStreamAvailable(stream) {
        console.log("onCombinedStreamAvailable");
        localStream = stream;

        videoElement.srcObject = localStream;
        videoElement.play();
        videoElement.muted = true;
        recBtn.disabled = false;
        shareBtn.disabled = true;
        stopBtn.disabled = true;
    }

    function onBtnRecordClicked() {
        console.log("onBtnRecordClicked");
        if (localStream != null) {
            mediaRecorder = new MediaRecorder(localStream);
            mediaRecorder.onstop = function() {
                console.log("mediaRecorder.onstop");

                var blob = new Blob(chunks, { type: "video/webm" });
                chunks = [];
                var videoURL = window.URL.createObjectURL(blob);

                downloadLink.href = videoURL;
                videoElement.src = videoURL;
                downloadLink.innerHTML = "Download video file";
                // console.log(videoURL);
            }

            let chunks = [];
            mediaRecorder.ondataavailable = function(e) {
                chunks.push(e.data);
            }

            mediaRecorder.start(2);
            console.log(mediaRecorder.state);

            recBtn.style.background = "red";
            recBtn.style.color = "black";

            recBtn.disabled = true;
            shareBtn.disabled = true;
            stopBtn.disabled = false;
        }else{
            console.log("localStream is missing");
        }
    }

    function onBtnStopClicked(){
        mediaRecorder.stop();
        console.log(mediaRecorder.state);
        console.log("recorder stopped");
        recBtn.style.background = "";
        recBtn.style.color = "";
    }
});