var lst = {login: "tomnguyen103", id: 26940725, node_id: "MDQ6VXNlcjI2OTQwNzI1", avatar_url: "https://avatars3.githubusercontent.com/u/26940725?v=4", gravatar_id: "",
avatar_url: "https://avatars3.githubusercontent.com/u/26940725?v=4",
bio: "Graduated BS Degree in Computer Science 2019, Graduated AA Degree in Pasadena City College 2014",
blog: "",
company: null,
created_at: "2017-04-05T20:59:38Z",
email: null,
events_url: "https://api.github.com/users/tomnguyen103/events{/privacy}",
followers: 2,
followers_url: "https://api.github.com/users/tomnguyen103/followers",
following: 18,
following_url: "https://api.github.com/users/tomnguyen103/following{/other_user}",
gists_url: "https://api.github.com/users/tomnguyen103/gists{/gist_id}",
gravatar_id: "",
hireable: true,
html_url: "https://github.com/tomnguyen103",
id: 26940725,
location: "Arcadia, CA",
login: "tomnguyen103",
name: "Tom Nguyen",
node_id: "MDQ6VXNlcjI2OTQwNzI1",
organizations_url: "https://api.github.com/users/tomnguyen103/orgs",
public_gists: 0,
public_repos: 13,
received_events_url: "https://api.github.com/users/tomnguyen103/received_events",
repos_url: "https://api.github.com/users/tomnguyen103/repos",
site_admin: false,
starred_url: "https://api.github.com/users/tomnguyen103/starred{/owner}{/repo}",
subscriptions_url: "https://api.github.com/users/tomnguyen103/subscriptions",
type: "User",
updated_at: "2019-10-28T17:37:02Z",
url: "https://api.github.com/users/tomnguyen103",
__proto__: Object,
}

console.log(lst.name);

var keys = Object.keys(lst);
keys.forEach(function(key){
    console.log(key, ":" ,lst[key]);
});