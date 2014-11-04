import web


urls = (
    '/(.*)', 'hello'
)


class hello:        
	def GET(self, name):
		try:
			return 'hola angel'
		except:
			return 'error'
			
if __name__ == "__main__":
	app = web.application(urls, globals())
	app.run()