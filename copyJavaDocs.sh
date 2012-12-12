rm -fr serverApi/*
rm -fr guiApi/*
cp -R server/target/site/apidocs/* serverApi 
cp -R GUI/target/site/apidocs/* guiApi 
