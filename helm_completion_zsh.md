## helm completion zsh

generate autocompletion script for zsh

### Synopsis


Generate the autocompletion script for Helm for the zsh shell.

To load completions in your current shell session:

    source <(helm completion zsh)

To load completions for every new session, execute once:

    helm completion zsh > "${fpath[1]}/_helm"


```
helm completion zsh [flags]
```

### Options

```
  -h, --help              help for zsh
      --no-descriptions   disable completion descriptions
```

### Options inherited from parent commands

```
      --burst-limit int                 client-side default throttling limit (default 100)
      --debug                           enable verbose output
      --kube-apiserver string           the address and the port for the Kubernetes API server
      --kube-as-group stringArray       group to impersonate for the operation, this flag can be repeated to specify multiple groups.
      --kube-as-user string             username to impersonate for the operation
      --kube-ca-file string             the certificate authority file for the Kubernetes API server connection
      --kube-context string             name of the kubeconfig context to use
      --kube-insecure-skip-tls-verify   if true, the Kubernetes API server's certificate will not be checked for validity. This will make your HTTPS connections insecure
      --kube-tls-server-name string     server name to use for Kubernetes API server certificate validation. If it is not provided, the hostname used to contact the server is used
      --kube-token string               bearer token used for authentication
      --kubeconfig string               path to the kubeconfig file
  -n, --namespace string                namespace scope for this request
      --qps float32                     queries per second used when communicating with the Kubernetes API, not including bursting
      --registry-config string          path to the registry config file (default "C:\\Users\\YelzhanRakhimzhanov\\AppData\\Roaming\\helm\\registry\\config.json")
      --repository-cache string         path to the directory containing cached repository indexes (default "C:\\Users\\YELZHA~1\\AppData\\Local\\Temp\\helm\\repository")
      --repository-config string        path to the file containing repository names and URLs (default "C:\\Users\\YelzhanRakhimzhanov\\AppData\\Roaming\\helm\\repositories.yaml")
```

### SEE ALSO

* [helm completion](helm_completion.md)	 - generate autocompletion scripts for the specified shell

###### Auto generated by spf13/cobra on 18-Jul-2025
