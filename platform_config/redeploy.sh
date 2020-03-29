#kubectl delete -f msa3-svc-member/deployment.yml
#kubectl delete -f msa3-svc-order/deployment.yml

docker build -t 192.168.100.102:5000/msasmp03/msa3-svc-order:1.0     msa3-svc-order/.
docker build -t 192.168.100.102:5000/msasmp03/msa3-svc-member:1.0    msa3-svc-member/.

docker push 192.168.100.102:5000/msasmp03/msa3-svc-order:1.0
docker push 192.168.100.102:5000/msasmp03/msa3-svc-member:1.0

kubectl apply -f <(istioctl kube-inject -f msa3-svc-order/deployment.yml)
kubectl apply -f <(istioctl kube-inject -f msa3-svc-member/deployment.yml)

kubectl rollout restart deployment/msa3-svc-order
kubectl rollout restart deployment/msa3-svc-member
