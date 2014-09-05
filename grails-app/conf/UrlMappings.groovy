class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "/phones"(version:'1.0', resources:"phone", namespace:'v1')
        "/phones"(version:'2.0', resources:"phone", namespace:'v2')
	}
}
