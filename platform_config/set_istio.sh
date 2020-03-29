
#### Download Istio
#Download latest version
curl -L https://istio.io/downloadIstio | sh -

#Specific Version
#curl -L https://istio.io/downloadIstio | ISTIO_VERSION=1.4.3 sh -

cd istio-1.5.1

#### Install Istio
#Installation YAML files for Kubernetes in install/kubernetes
export PATH=$PWD/bin:$PATH
istioctl manifest apply --set profile=demo


kubectl get svc istio-ingressgateway -n istio-system

#### Deploy the sample application
#deploy book info example
kubectl apply -f samples/bookinfo/platform/kube/bookinfo.yaml
kubectl apply -f <(istioctl kube-inject -f /sw/istio/istio-1.5.1/samples/bookinfo/platform/kube/bookinfo.yaml)

#Verify everything is working Propery
kubectl exec -it $(kubectl get pod -l app=ratings -o jsonpath='{.items[0].metadata.name}') -c ratings -- curl productpage:9080/productpage | grep -o "<title>.*</title>"

#### Open the application to outside traffic
#associate this app with the istio gateway
kubectl apply -f samples/bookinfo/networking/bookinfo-gateway.yaml
kubectl apply -f <(istioctl kube-inject -f /sw/istio/istio-1.5.1/samples/bookinfo/networking/bookinfo-gateway.yaml)
kubectl get gateway


#### Determining the ingress IP and ports
#Set the ingress IP and ports:
export INGRESS_HOST=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].port}')
export SECURE_INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].port}')

#the load balancer may be exposed using a host name, instead of an IP address
export INGRESS_HOST=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].hostname}')

#if your environment does not have an external load balancer and choose a node port instead
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
export SECURE_INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="https")].nodePort}')
export INGRESS_HOST=$(kubectl get po -l istio=ingressgateway -n istio-system -o jsonpath='{.items[0].status.hostIP}')
export GATEWAY_URL=$INGRESS_HOST:$INGRESS_PORT
istioctl dashboard kiali

kubectl apply -f <(istioctl kube-inject -f /sw/istio/istio-1.5.0/samples/bookinfo/networking/virtual-service-all-v1.yaml)
kubectl get destinationrules -o yaml

istioctl manifest generate --set profile=demo | kubectl delete -f -
$ samples/bookinfo/platform/kube/cleanup.sh