## helm history

fetch release history

### Synopsis


History prints historical revisions for a given release.

A default maximum of 256 revisions will be returned. Setting '--max'
configures the maximum length of the revision list returned.

The historical release set is printed as a formatted table, e.g:

    $ helm history angry-bird
    REVISION    UPDATED                     STATUS          CHART             APP VERSION     DESCRIPTION
    1           Mon Oct 3 10:15:13 2016     superseded      alpine-0.1.0      1.0             Initial install
    2           Mon Oct 3 10:15:13 2016     superseded      alpine-0.1.0      1.0             Upgraded successfully
    3           Mon Oct 3 10:15:13 2016     superseded      alpine-0.1.0      1.0             Rolled back to 2
    4           Mon Oct 3 10:15:13 2016     deployed        alpine-0.1.0      1.0             Upgraded successfully


```
helm history RELEASE_NAME [flags]
```

### Options

```
  -h, --help            help for history
      --max int         maximum number of revision to include in history (default 256)
  -o, --output format   prints the output in the specified format. Allowed values: table, json, yaml (default table)
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

* [helm](helm.md)	 - The Helm package manager for Kubernetes.

###### Auto generated by spf13/cobra on 18-Jul-2025
