// //Import the filestack api key
// const client = filestack.init(apiKey);
//
// //Create a set of parameters for the filestack api
// const options = {
//     onUploadDone: pickMark(),
//     accept: ['image/*', 'video/*']
// };
//
// //Create a variable that grabs a html element
// var openFileStacker = document.getElementById("picker");
//
// //Uses the variable above to open the filestack api upload window
// openFileStacker.addEventListener('click', function (e) {
//     e.preventDefault();
//     client.picker(options).open();
// });
//
//
// function pickMark() {
//     console.log("Uploading Photo");
//     //Opening the file picker here
//     client.picker({
//         accept: 'image/*',
//         maxFiles:1
//     }).then(function(result) /*error here, claims to not be a function*/{
//         console.log("File url: " + result.filesUploaded[0].url);
//         console.log(pickWatermark);
//         document.getElementById("picker").value = result.filesUploaded[0].url;
//     });
// }





















// const options = {
//     onUploadDone: pickMark(),
//     maxSize: 10 * 1024 * 1024,
//     accept: ['image/*', 'video/*'],
//     uploadInBackground: false,
//     storeTo: {
//         workflows: ["1d91169c-19b3-4114-8047-c49cfe9d8535"]
//     }
// };
// client.picker().open();
//
//
// const form = document.getElementById('pick-form');
// const fileInput = document.getElementById('fileupload');
// const btn = document.getElementById('picker');
// const nameBox = document.getElementById('nameBox');
// const urlBox = document.getElementById('urlBox');
//
// // Add our event listeners
//
// btn.addEventListener('click', function (e) {
//     e.preventDefault();
//     picker.open();
// });
//
// form.addEventListener('submit', function (e) {
//     e.preventDefault();
//     alert('Submitting: ' + fileInput.value);
// });
//
// // Helper to overwrite the field input value
// function pickMark() {
//     console.log("Uploading Photo");
//     //Opening the file picker here
//     client.pick({
//         accept: 'image/*',
//         maxFiles:1
//     }).then(function(result) {
//         console.log("File url: " + result.filesUploaded[0].url);
//         console.log(pickWatermark);
//         document.getElementById("profileImageUrl").value = result.filesUploaded[0].url;
//     });
// }

// const picker = client.picker(options);
// client.pick({
//     accept: 'image/*',
// }).then(function(result) {
//     console.log(result);
//     alert("Your files is available here: " + result.filesUploaded[0].url);
// });
// const picker = client.picker(options);

// client.picker(options).onUploadDone();
// Get references to the DOM elements

// function updateForm(result) {
//     const fileData = result.filesUploaded[0];
//
//     fileInput.value = fileData.url;
//
//     // Some ugly DOM code to show some data.
//     const name = document.createTextNode('Selected: ' + fileData.filename);
//     const url = document.createElement('a');
//     url.href = fileData.url;
//     url.appendChild(document.createTextNode(fileData.url));
//     nameBox.appendChild(name);
//     urlBox.appendChild(document.createTextNode('Uploaded to: '));
//     urlBox.appendChild(url);
//     console.log(result);
//     updateForm(fileData.url);
//     console.log(fileData.url)
// }

// const client = filestack.init(apiKey);
// const options = {
//     onUploadDone: updateForm,
//     maxSize: 10 * 1024 * 1024,
//     accept: ['image/*', 'video/*'],
//     uploadInBackground: false,
//     storeTo: {
//         workflows: ["1d91169c-19b3-4114-8047-c49cfe9d8535"]
//     }
//
// };
// const picker = client.picker(options);
//
// // bind the on-change event
// const btn = document.getElementById('upload-file-input');
// btn.addEventListener('click', function (e) {
//     e.preventDefault();
//     picker.open();
// });
// // $(document).ready(function() {
// //     $("#upload-file-input").on("change", uploadFile);
// // });
//
// /**
//  * Upload the file sending it via Ajax at the Spring Boot server.
//  */
// function uploadFile() {
//     $.ajax({
//         url: "/uploadFile",
//         type: "POST",
//         data: new FormData($("#upload-file-form")[0]),
//         enctype: 'multipart/form-data',
//         processData: false,
//         contentType: false,
//         cache: false,
//         success: function () {
//             // Handle upload success
//             // ...
//         },
//         error: function () {
//             // Handle upload error
//             // ...
//         }
//     });
// } // function uploadFile
//







// const client = filestack.init(apiKey);
// const options = {
//     onUploadDone: updateForm,
//     maxSize: 10 * 1024 * 1024,
//     accept: ['image/*', 'video/*'],
//     uploadInBackground: false,
//     storeTo: {
//         workflows: ["1d91169c-19b3-4114-8047-c49cfe9d8535"]
//     }
//
// };
// const picker = client.picker(options);
// // client.pick({
// //     accept: 'image/*',
// // }).then(function(result) {
// //     console.log(result);
// //     alert("Your files is available here: " + result.filesUploaded[0].url);
// // });
// // const picker = client.picker(options);
//
// // client.picker(options).onUploadDone();
// // Get references to the DOM elements
//
// const form = document.getElementById('pick-form');
// const fileInput = document.getElementById('fileupload');
// const btn = document.getElementById('picker');
// const nameBox = document.getElementById('nameBox');
// const urlBox = document.getElementById('urlBox');
//
// // Add our event listeners
//
// btn.addEventListener('click', function (e) {
//     e.preventDefault();
//     picker.open();
// });
//
// form.addEventListener('submit', function (e) {
//     e.preventDefault();
//     alert('Submitting: ' + fileInput.value);
// });
//
// // Helper to overwrite the field input value
//
// function updateForm(result) {
//     const fileData = result.filesUploaded[0];
//     fileInput.value = fileData.url;
//
//     // Some ugly DOM code to show some data.
//     const name = document.createTextNode('Selected: ' + fileData.filename);
//     const url = document.createElement('a');
//     url.href = fileData.url;
//     url.appendChild(document.createTextNode(fileData.url));
//     nameBox.appendChild(name);
//     urlBox.appendChild(document.createTextNode('Uploaded to: '));
//     urlBox.appendChild(url);
//     console.log(result);
// }
//
// function fileUpload(){
//     $.ajax({
//         url: "/image",
//         type: "POST",
//         data: new FormData($("#fileupload")[0]),
//         enctype: 'multipart/form-data',
//         processData: false,
//         contentType: false,
//         cache: false,
//         success: function () {
//             // Handle upload success
//             // ...
//         },
//         error: function () {
//             // Handle upload error
//             // ...
//         }
//     });
// } // function uploadFile